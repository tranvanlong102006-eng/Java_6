<template>
    <FormNhanVienCompontent v-model:newNhanVien="newNhanVien" />
    <button v-if="!newNhanVien.id" @click="addNhanVien">Add</button>
     <button  @click="updateNhanVien">Update</button>
  <table>
    <thead>
        <tr>
            <td>STT</td>
            <td>Ma nhan vien</td>
            <td>Ten nhan vien</td>
            <td>Gioi tinh</td>
            <td>Ten chuc vu</td>
            <td>Hanh dong</td>
        </tr>
    </thead>
    ,<tbody>
        <tr v-for="(item, index) in listNhanVien" :key="item.id">
            <td>{{ index + 1 }}</td>
            <td>{{ item.maNhanVien }}</td>
            <td>{{ item.tenNhanVien }}</td>
            <td>{{ item.gioiTinh }}</td>
            <td>{{ item.tenChucVu }}</td>
            <td>
                <button @click="detailNhanVien(item.id)">Detail</button>
                 <button @click="deleteNhanVien(item.id)">Delete</button>
            </td>
        </tr>
    </tbody>
  </table>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getListNhanVienService, detailNhanVienService, searchNhanVienService, addNhanVienService, updateNhanVienService, deleteNhanVienService} from '@/service/NhanVienService.js'
import FormNhanVienCompontent from '@/compontent/FormNhanVienCompontent.vue';


const listNhanVien = ref([]);
const newNhanVien = ref({})

const getAllNhanVien = async() =>{
    listNhanVien.value = await getListNhanVienService();
}

const detailNhanVien = async(id) =>{
    newNhanVien.value  = await detailNhanVienService(id)
}

const addNhanVien = async () => {
    await addNhanVienService(newNhanVien.value);
    alert("Thêm thành công!");
    await getAllNhanVien(); // Gọi lại để cập nhật danh sách
    newNhanVien.value = {}; // Reset form
}

const updateNhanVien = async () => {
    await updateNhanVienService(newNhanVien.value, newNhanVien.value.id);
    alert("Cập nhật thành công!");
    await getAllNhanVien(); 
    newNhanVien.value = {}; 
}

const deleteNhanVien = async (id) => {
    if(confirm("Bạn có chắc muốn xóa?")) {
        await deleteNhanVienService(id);
        await getAllNhanVien(); 
    }
}

onMounted(getAllNhanVien)

</script>

<style scoped>

</style>