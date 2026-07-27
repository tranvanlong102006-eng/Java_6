<template>
   <form>
    Ma ban: <input type="text" v-model="newBan.maBan"> <br>
     Ten ban: <input type="text" v-model="newBan.tenBan"> <br>
     Ngay sinh: <input type="date" v-model="newBan.ngaySinh"> <br>
     Moi quan he: <select v-model="newBan.moiQuanHeId">
        <option value="">Chon moi quan he</option>
        <option v-for="item in listMoiQuanHe" :key="item.id" :value="item.id">{{ item.tenMoiQuanHe }}</option>
     </select>
   </form>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getListMoiQuanHeService } from '@/service/MoiQuanHeService.js'

defineModel("newBan")
const listMoiQuanHe = ref([])

const getListMoiQuanHe = async () => {
    listMoiQuanHe.value = await getListMoiQuanHeService();
}

onMounted(getListMoiQuanHe)

</script>

<style scoped></style>