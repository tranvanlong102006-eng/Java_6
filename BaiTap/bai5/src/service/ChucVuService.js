const api = "http://localhost:8080/api/chuc-vu";

export const getListChucVuService = async () => {
  const res = await fetch(api);
  return res.json();
}
