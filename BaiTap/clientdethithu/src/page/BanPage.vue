<template>
    <FormBanCompontent v-model:newBan="newBan" />
    <button @click="updateBan">Update</button>
    <table>
        <thead>
            <tr>
                <td>STT</td>
                <td>Ma ban</td>
                <td>Ho ten</td>
                <td>Ngay sinh</td>
                <td>Ma moi quan he</td>
                <td>Ten moi quan he</td>
                <td>Hanh dong</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(item, index) in listBan" :key="item.id">
                <td>{{ index + 1 }}</td>
                <td>{{ item.maBan }}</td>
                <td>{{ item.tenBan }}</td>
                <td>{{ item.ngaySinh }}</td>
                <td>{{ item.maMoiQuanHe }}</td>
                <td>{{ item.tenMoiQuanHe }}</td>
                <td>
                    <button @click="detailBan(item.id)">Detail</button>
                    <button @click="deleteBan(item.id)">Delete</button>
                </td>
            </tr>
        </tbody>
    </table>

</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getListBanService, detailBanService, updateBanService, deleteBanService } from '@/service/BanService.js'
import FormBanCompontent from '@/compontent/FormBanCompontent.vue';


const listBan = ref([])
const newBan = ref({})

const getListBan = async () => {
    listBan.value = await getListBanService();
}

const detailBan = async(id) =>{
    newBan.value = await detailBanService(id);
}

const deleteBan = async(id) =>{
    await deleteBanService(id);
    await getListBan();
}

const updateBan = async() =>{
    await updateBanService(newBan.value, newBan.value.id);
    await getListBan();
}



onMounted(getListBan)
</script>

<style scoped></style>