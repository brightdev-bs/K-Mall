import axios from "axios";
import {ref, unref} from "vue";
import { Error } from "@/global/constants"

axios.defaults.baseURL = import.meta.env.VITE_BACKEND_ADDRESS

const defaultConfig = {
    method: 'get',
}

const defaultOptions = {
    immediate: true,
}

export const useAxios = (url, config = {}, options = {}) => {
    const response = ref(null);
    const data = ref(null);
    const loading = ref(false);

    const { onSuccess, onError, immediate } = {
        ...defaultOptions,
        ...options,
    }

    const { params } = config;

    const execute = body => {
        data.value = null;
        loading.value = true;
        axios(unref(url), {
            ...defaultConfig,
            ...config,
            params: unref(params),
            data: typeof body === 'object' ? body : {},
        }).then(res => {
            response.value = res;
            data.value = res.data;
            if(onSuccess) onSuccess(res);
        }).catch(err => {
          handleAxiosError(err, onError);
        }).finally(() => {
            loading.value = false;
        })
    }

    if (immediate) {
        execute();
    }

  function handleAxiosError(err, customErrorHandler) {
      console.log(err);
      console.log(err.response);
    if(!err.response) {
      showAlert("서버가 응답하지 않았습니다.")
      return;
    }

    const { data } = err.response;
    console.log(data);
    switch (data.message) {
      case Error.EXPIRED_TOKEN:
      case Error.INVALID_TOKEN:
        handleTokenError();
        break;

      case Error.NOT_FOUND_TOKEN:
        handleNotFoundToken();
        break;

      default:
        showAlert(data.message);
        if (customErrorHandler) customErrorHandler(err);
    }
  }

  function showAlert(message) {
    alert(message);
  }

  function handleTokenError() {
    clearLocalStorage();
    confirm("session is expired. please re-login", "OK");
  }

  function handleNotFoundToken() {
    confirm("Only member can request. Please login first", "OK");
  }

  function clearLocalStorage() {
    localStorage.removeItem("id");
    localStorage.removeItem("token");
    localStorage.removeItem('name');
  }


  function removeLocalStorage() {
        localStorage.removeItem("id");
        localStorage.removeItem("token");
        localStorage.removeItem('name');
    }

  return {
      response,
      data,
      loading,
      submitExecute: execute,
  };
}
