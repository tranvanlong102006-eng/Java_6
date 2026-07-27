const api = "http://localhost:8080/api/moi-quan-he";

export const getListMoiQuanHeService = async() =>{
    const res = await fetch(api);
    return res.json();
}