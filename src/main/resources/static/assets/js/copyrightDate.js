'use strict';

const date = new Date();

if (date.getFullYear() === 2021) {
    $('#yearSpan').text(date.getFullYear());
} else {
    $('#yearSpan').text("2021 - " + date.getFullYear());
}