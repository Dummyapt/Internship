package de.dummyapt.internship.registration;

import de.dummyapt.internship.appuser.AppUser;
import de.dummyapt.internship.appuser.AppUserRole;
import de.dummyapt.internship.appuser.AppUserService;
import de.dummyapt.internship.email.EmailSender;
import de.dummyapt.internship.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

// TODO: 12.07.2021 Write JavaDoc comments
/**
 * Service class for {@link RegistrationControllerREST}
 */
@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest request) {
        if (!emailValidator.test(request.getEmail())) {
            return "Email not valid!";
        }

        if (!request.getPassword().equals(request.getPasswordConfirmation())) {
            return "Passwords don't match!";
        }

        String token = appUserService.signUpUser(
                new AppUser(
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );

        var link = "http://localhost:8080/register/confirm?token=" + token;
        emailSender.send(request.getEmail(), buildEmail(request.getUsername(), link));

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        var confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token not found!"));

        if (confirmationToken.getConfirmedAt() != null) {
            return "Email already confirmed!";
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            return "Token expired!";
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return confirmationPage();
    }

    private String confirmationPage() {
        return """
                <h1 class="display-3">Thank You!</h1>
                <p class="lead"><strong>Please check your email</strong> for further instructions on how to complete your account setup.</p>""";
    }

    private String buildEmail(String username, String link) {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("""
                <div style="font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c">
                    <span style="display:none;font-size:1px;color:#fff;max-height:0"></span>
                    <table role="presentation" width="100%" style="border-collapse:collapse;min-width:100%;width:100%!important"
                        cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <tr>
                                <td width="100%" height="53" bgcolor="#0b0c0c">
                                    <table role="presentation" width="100%" style="border-collapse:collapse;max-width:580px"
                                        cellpadding="0" cellspacing="0" border="0" align="center">
                                        <tbody>
                                            <tr>
                                                <td width="70" bgcolor="#0b0c0c" valign="middle">
                                                    <table role="presentation" cellpadding="0" cellspacing="0" border="0"
                                                        style="border-collapse:collapse">
                                                        <tbody>
                                                            <tr>
                                                                <td style="padding-left:10px">
                                                                </td>
                                                                <td
                                                                    style="font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px">
                                                                    <span
                                                                        style="font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block">Confirm
                                                                        your email</span>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table role="presentation" class="m_-6186904992287805515content" align="center" cellpadding="0" cellspacing="0"
                        border="0" style="border-collapse:collapse;max-width:580px;width:100%!important" width="100%">
                        <tbody>
                            <tr>
                                <td width="10" height="10" valign="middle"></td>
                                <td>
                                    <table role="presentation" width="100%" cellpadding="0" cellspacing="0" border="0"
                                        style="border-collapse:collapse">
                                        <tbody>
                                            <tr>
                                                <td bgcolor="#1D70B8" width="100%" height="10"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td width="10" valign="middle" height="10"></td>
                            </tr>
                        </tbody>
                    </table>
                    <table role="presentation" class="m_-6186904992287805515content" align="center" cellpadding="0" cellspacing="0"
                        border="0" style="border-collapse:collapse;max-width:580px;width:100%!important" width="100%">
                        <tbody>
                            <tr>
                                <td height="30"><br></td>
                            </tr>
                            <tr>
                                <td width="10" valign="middle"><br></td>
                                <td
                                    style="font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px">
                                    <p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c">Hi\040""")
                .append(username)
                .append("""
                                         ,</p>
                                    <p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c"> Thank you for
                                        registering. Please click on the below link to activate your account: </p>
                                    <blockquote
                                        style="Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px">
                                        <p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c"> <a href="
                                        """)
                .append(link)
                .append("""
                                            ">Activate Now</a> </p>
                                    </blockquote>Link will expire in 15 minutes.
                                    <p>See you soon</p>
                                </td>
                                <td width="10" valign="middle"><br></td>
                            </tr>
                            <tr>
                                <td height="30"><br></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="yj6qo">Test</div>
                    <div class=adL>Test</div>
                </div>""");
        return stringBuilder.toString();
    }
}