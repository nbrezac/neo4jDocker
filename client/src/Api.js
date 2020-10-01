import axios from 'axios'

const SERVER_URL = 'http://neo4jexample:8080';

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000
});

export default {
    getAllPersons: () => instance.get("api/person/getAllPersons", {
                                                         transformResponse: [(data) => {
                                                                                   let resp

                                                                                   try {
                                                                                     resp = JSON.parse(data)
                                                                                   } catch (error) {
                                                                                     throw Error(`[requestClient] Error parsing response JSON data - ${JSON.stringify(error)}`)
                                                                                   }
                                                                                   console.log("resp:" + resp);
                                                                                   console.log("resp.status:" + resp.status);
                                                                                   return resp;

                                                                                 }]
                                                       })

}