import axios from "axios";

// connects us to the Users endpoint
const USERS_API_BASE_URL = "http://localhost:8080/users"

class UserService {
    
    // GET

    // get all users
    getUsers() {
        return axios.get(USERS_API_BASE_URL + '/all');
    }

    // get user by id
    getUserById(userID) {
        return axios.get(USERS_API_BASE_URL + '/' + userID)
    }

    // POST
    createUser(user) {
        const add_user = USERS_API_BASE_URL + '/add-user-market'
        return axios.post(add_user, user)
    }
    // PUT

    updateUser(user, userId){
        const udpate_user = USERS_API_BASE_URL + '/update/' + userId;
        return axios.put(udpate_user, user);
    }

    // DELETE

    deleteUser(userID) {
        return axios.delete(USERS_API_BASE_URL + '/delete/' + userID)
    }



}

// export so that we can import into different js files
export default new UserService()