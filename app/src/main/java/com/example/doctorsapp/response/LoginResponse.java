package com.example.doctorsapp.response;

public class LoginResponse {
        private float response;
        private boolean auth;
        private String token;
        private String uid;
        private String name;
        private   String message;




// Getter Methods

        public float getResponse() {
            return response;
        }
    public String getMessage() {
        return message;
    }
        public boolean getAuth() {
            return auth;
        }

        public String getToken() {
            return token;
        }

        public String getUid() {
            return uid;
        }

        public String getName() {
            return name;
        }

        // Setter Methods

        public void setResponse(float response) {
            this.response = response;
        }

        public void setAuth(boolean auth) {
            this.auth = auth;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

    public void setMessage(String message) {
        this.message = message;
    }

        public void setName(String name) {
            this.name = name;
        }

}
