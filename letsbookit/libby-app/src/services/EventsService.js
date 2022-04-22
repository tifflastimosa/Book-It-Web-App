import axios from "axios";

const EVENTS_API_BASE_URL = "http://localhost:8080/events"

class EventsService {

    // POST


    // GET

    // get all events
    getEvents() {
        return axios.get(EVENTS_API_BASE_URL);
    }

    // get user by id
    getEventById(eventID) {
        return axios.get(EVENTS_API_BASE_URL + '/' + eventID)
    }

    // PUT


    // DELETE

    deleteEvent(eventID) {
        return axios.delete(EVENTS_API_BASE_URL + '/delete/' + eventID)
    }



}

// export so that we can import into different js files
export default new EventsService()