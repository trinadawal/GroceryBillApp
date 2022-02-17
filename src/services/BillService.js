import axios from 'axios';

const REGULAR_BILL_API_BASE_URL = "http://localhost:8082/ecz/api/item/regularBill";
const DISCOUNTED_BILL_API_BASE_URL = "http://localhost:8083/ecz/api/item/discountedBill";

class BillService {

    getTotalRegularBill() {
        return axios.get(REGULAR_BILL_API_BASE_URL);
    }

    getTotalDiscountedBill() {
        return axios.get(DISCOUNTED_BILL_API_BASE_URL);
    }

}

export default new BillService();