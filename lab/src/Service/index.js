import axios from 'axios';
//import { getToken } from '../Config/token';

const api = axios.create({
    baseURL: process.env.REACT_APP_API || 'http://localhost:8080',
});

const apiRoutes = {
    UPLOAD_IMG: '/upload_file/upload_img',
    GET_IMG: '/upload_file/get',
};

export { api, apiRoutes };