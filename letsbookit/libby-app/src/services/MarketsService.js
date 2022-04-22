import axios from "axios";

const MARKETS_API_BASE_URL = "http://localhost:8080/markets"

class MarketsService {



    // GET

    // get all markets
    getMarkets() {
        return axios.get(MARKETS_API_BASE_URL)
    }

    getMarketById(marketId) {
        return axios.get(MARKETS_API_BASE_URL + '/' + marketId)
    }

    // DELETE
    deleteMarketById(marketID) {
        return axios.delete(MARKETS_API_BASE_URL + '/delete/' + marketID)
    }
}

export default new MarketsService()