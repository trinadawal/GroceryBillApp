import axios from 'axios';

const CLERK_API_BASE_URL = "http://localhost:8081/ecz/api/clerk";

class ClerkService {

    clerkLogIn(clerkName, clerkPassword) {
        return axios.get(CLERK_API_BASE_URL + "/validate/" + clerkName + "/" + clerkPassword);
    }
}

export default new ClerkService();