<template>
    <form>
        <input type="hidden" v-model="newNhanVien.id">
        Mã nhân viên: <input type="text" v-model="newNhanVien.maNhanVien"> <br>
        Tên nhân viên: <input type="text" v-model="newNhanVien.tenNhanVien"> <br>
        Giới tính: 
        <input type="radio" v-model="newNhanVien.gioiTinh" id="male" :value="true"> <label for="male">Nam</label>
        <input type="radio" v-model="newNhanVien.gioiTinh" id="female" :value="false"> <label for="female">Nữ</label> <br>
        Chức vụ: 
        <select v-model="newNhanVien.chucVuId">
            <option value="">Chọn chức vụ</option>
            <option v-for="item in listChucVu" :key="item.id" :value="item.id"> {{ item.tenChucVu }}
            </option>
        </select>
    </form>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getListChucVuService} from '@/service/ChucVuService.js'


defineModel("newNhanVien")

const listChucVu = ref([])
const getListChucVu = async () => {
    listChucVu.value = await getListChucVuService();
}

onMounted(getListChucVu)
</script>

<style scoped></style>