import axios from "axios";
import authHeader from "./authHeader";

const API_URL = "http://localhost:8080/api/categories";

const saveCategory = ({ categoryName }) => {
    return axios
        .post(API_URL, {
            categoryName,
        }, { headers: authHeader() });
}

const editCategory = ({ categoryName, categoryId }) => {
    return axios
        .put(API_URL + `/${categoryId}`, {
            categoryName
        }, { headers: authHeader() });
}

const deleteCategory = (id) => {
    return axios
        .delete(API_URL + `/${id}`, {
            headers: authHeader()
        });
}

const getAllCategories = () => {
    return axios
        .get(API_URL, { headers: authHeader() })
}

export default {
    saveCategory,
    deleteCategory,
    editCategory,
    getAllCategories
}