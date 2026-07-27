const api = "http://localhost:8080/api/ban";

export const getListBanService = async() =>{
    const res = await fetch(api)
    return res.json();
}

export const detailBanService = async(id) =>{
    const res = await fetch(`${api}/detail/${id}`)
    return res.json();
}

export const updateBanService = async(data, id) =>{
      await fetch(`${api}/update/${id}`, {
        method: "PUT",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      })
 
}

export const deleteBanService = async( id) =>{
     await fetch(`${api}/delete/${id}`, {
        method: "DELETE",
      })

}