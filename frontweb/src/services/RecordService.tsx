import Axios from "axios";
import URLBase from "./URLBase"

export const listRecords: any = async (page: number) => {
  return await Axios.get(`${URLBase}/records?linesPerPage=10&page=${page}`);
}