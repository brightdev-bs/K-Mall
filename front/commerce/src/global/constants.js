// [Token]
export const Error = {
        EXPIRED_TOKEN: "Expired token",
        INVALID_TOKEN: 'Wrong header token',
        NOT_FOUND_TOKEN: 'There is no token',
}

export const Response = {
        SUCCESS: 'Successfully processed',
        FAIL: 'Something happened. Try again'
}

export const Constants = {
        'FACEBOOK': 'facebook',
        'GOOGLE': 'google',
};

export const Url = {
    'FACEBOOK_URL': 'https://accounts.google.com/o/oauth2/v2/auth?client_id='
        + process.env.VUE_APP_GOOGLE_CLIENT_ID + '&redirect_url='
        + process.env.VUE_APP_GOOGLE_REDIRECT_URL
        + '&response_type=code'
        + '&scope=email profile',
}


export * from "@/global/constants.js";
