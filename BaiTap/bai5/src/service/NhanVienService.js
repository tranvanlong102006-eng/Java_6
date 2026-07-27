const api = "http://localhost:8080/api/nhan-vien";

export const getListNhanVienService = async () => {
  const res = await fetch(api);
  return res.json();
}

export const addNhanVienService = async (data) => {
  const res = await fetch(`${api}/add`, {
    method: "POST", // Đổi thành POST
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data)
  });
  return res.json();
}

export const updateNhanVienService = async (data, id) => {
  const res = await fetch(`${api}/update/${id}`, {
    method: "PUT", // Đổi thành PUT
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data) // Sửa lỗi chính tả stringify
  });
  return res.json();
}
// ... Các hàm khác giữ nguyên nhưng nên có return res.json()


export const detailNhanVienService = async (id) => {
  const res = await fetch(`${api}/detail/${id}`);
  return res.json();
}

export const searchNhanVienService = async (searchText = "") => {
  const res = await fetch(`${api}/search?ten=${searchText}`);
  return res.json();
}


export const deleteNhanVienService = async (id) => {
  const res = await fetch(`${api}/delete/${id}`, {
    method: "DELETE",
  });
  return res.json();
}
