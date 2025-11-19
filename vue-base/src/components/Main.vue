<template>
     <el-scrollbar>
        <div style="margin-bottom: 5px; margin-top: 5px;">
          <el-input v-model="name"
            placeholder="Buscar por nombre" style="width: 200px;":suffix-icon="Search" @keyup.enter.native="loadPage"></el-input>
              <el-select
                v-model="sex"
                filterable
                placeholder="Seleccionar sexo "
                style="width: 150px; margin-left: 5px;"
                @change="serachBySex"
              >
              <el-option
                  v-for="item in sexs"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
               />
  </el-select>
          <el-button type="primary" style="margin-left: 5px;" @click="searchByName">Buscar</el-button>
          <el-button type="success" @click="resetParam">Resetear</el-button>
          <el-button type="primary" style="margin-left: 5px;" @click="add">Añadir</el-button>
        </div>
          <div>
              <el-table :data="tableData"
              :header-cell-style="{ background: '#f2f5fc', color: '#555555' }">
                <el-table-column prop="id" label="ID" width="90" />
                <el-table-column prop="no" label="Usuario" width="280" />
                <el-table-column prop="name" label="Nombre" width="280" />
                <el-table-column prop="age" label="Edad" width="160"/>
                <el-table-column prop="sex" label="Sexo"width="160" >
                  <template #default="scope">
                          <el-tag
                            :type="scope.row.sex === '1' ? 'primary' : 'success'"
                            disable-transitions
                            >{{ scope.row.sex === 1 ? 'Hombre' : 'Mujer' }}</el-tag
                          >
                  </template>
                </el-table-column>
                <el-table-column prop="roleId" label="Role" width="180">
                      <template #default="scope">
                          <el-tag
                              :type="scope.row.id === 1
                              ? 'danger'
                              : (scope.row.roled === 1 ? 'primary' : 'success')"
                          >
                            {{
                              scope.row.id === 1
                                ? 'SuperAdmin'
                                : (scope.row.roled === 1 ? 'Admin' : 'Usuario')
                            }}</el-tag
                        >
                  </template>
                  </el-table-column>
                <el-table-column prop="phone" label="Telefono" width="280" />
                <el-table-column prop="operate" label="Accion">
                  <el-button type="success">Editar</el-button>
                  <el-button type="danger">Eliminar</el-button>
                </el-table-column>
              </el-table>
                  <el-pagination
                    v-model:current-page="pageNum"
                    v-model:page-size="pageSize"
                    :page-sizes="[2, 5, 10, 20]"
                    :size="size"
                    :disabled="disabled"
                    :background="background"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    />
                <el-dialog
                  title="Añadir Usuario"
                  v-model="centerDialogVisible"
                  width="30%"
                  >
                  <div class="dialogo">
                  <el-form :model="form" label-width="auto" style="max-width: 600px">
                        <el-form-item label="Nombre usuario">
                          <el-col :span="15">
                           <el-input v-model="form.userName" />
                          </el-col>
                        </el-form-item>
                           <el-form-item label="Nombre">
                          <el-col :span="15">
                           <el-input v-model="form.name" />
                          </el-col>
                        </el-form-item>
                           <el-form-item label="Contraseña">
                          <el-col :span="20">
                           <el-input v-model="form.password" />
                          </el-col>
                        </el-form-item>
                           <el-form-item label="Edad">
                          <el-col :span="5">
                           <el-input v-model="form.age" />
                          </el-col>
                        </el-form-item>
                        <el-form-item label="Resources">
                          <el-radio-group v-model="form.sex">
                            <el-radio value="Hombre">Hombre</el-radio>
                            <el-radio value="Mujer">Mujer</el-radio>
                           </el-radio-group>
                        </el-form-item>
                           <el-form-item label="Telefono">
                          <el-col :span="20">
                           <el-input v-model="form.phone" />
                          </el-col>
                        </el-form-item>
                       
                  </el-form>
                   <div class="dialog-buttons">
                  <el-button
                    @click="centerDialogVisible = false">Cancelar</el-button>
                  <el-button type="primary"
                    @click="saveUser">Confirmar</el-button>
                    </div>
                  </div>
                 </el-dialog> 
            </div>
        </el-scrollbar>
</template>

<script lang="ts" setup>
import { onBeforeMount, ref } from 'vue'
import axios from 'axios'  
import {Search } from '@element-plus/icons-vue'
import type { ComponentSize } from 'element-plus'
import { ElMessage } from 'element-plus'

const centerDialogVisible = ref(false)
const pageSize = ref(5)
const pageNum = ref(1)
const total = ref(0)
const sex = ref('')
const sexs = ref([
  { value: '1', label: 'Hombre' },
  { value: '2', label: 'Mujer' }
])
const form = ref({
  name: '',
  userName: '',
  password: '',
  age: '',
  phone: '',
  sex: '0',
  roled: '1'

})
const size = ref<ComponentSize>('default')
const name = ref('')
const background = ref(false)
const disabled = ref(false)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
  pageSize.value = val
  loadPage()
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
  pageNum.value = val
  loadPage()
}


const tableData = ref([])

function saveUser(){

    axios.post('/save', {
      name: form.value.name,
      no: form.value.userName,
      password: form.value.password,
      age: form.value.age,
      phone: form.value.phone,
      roled: form.value.roled,
       
  }).then((response) => {  
    console.log(response.data);
    if(response.data.code === 200){
       
        ElMessage({
          message: 'Se ha guardado el usaurio con exito.',
          type: 'success',});
       centerDialogVisible.value = false
    } else {
    
        ElMessage({
          message: 'No se ha podido guardar el usuario.',
          type: 'warning',
         })
    }
  }).catch((error) => {
    console.error('请求失败:', error);
  })

}
function loadGet(){
  axios.get('/listP').then(response=>response.data).then((response)=>{
    console.log(response.data);
    if(response.code === 200){
    tableData.value = response.data;
    }else {
      alert('Error al cargar los datos de la tabla');
    }
   
  }).catch((error) => {
    console.error('请求失败:', error);
  })
}

function loadPage(){
  axios.post('/listPage', {
      pageNum: pageNum.value,
      pageSize: pageSize.value,
        param: {
      name: name.value || undefined,
      sex: sex.value || undefined
    }
  }).then((response) => {  
    console.log(response.data);
    if(response.data.code === 200){
      tableData.value = response.data.data;  
      total.value = response.data.total;
    } else {
      alert('Error al cargar los datos de la tabla');
    }
  }).catch((error) => {
    console.error('请求失败:', error);
  })
}

function searchByName(){
  axios.post('/listPage', {
      pageNum: pageNum.value,
      pageSize: pageSize.value,
      param:{
        name: name.value
      }
  }).then((response) => {  
    console.log(response.data);
    if(response.data.code === 200){
      tableData.value = response.data.data;  
      total.value = response.data.total;
    } else {
      alert('Error al cargar los datos de la tabla');
    }
  }).catch((error) => {
    console.error('请求失败:', error);
  })
}

function serachBySex(){
    axios.post('/listPageSex', {
      pageNum: pageNum.value,
      pageSize: pageSize.value,
      param:{
        sex: sex.value
      }
  }).then((response) => {  
    console.log(response.data);
    if(response.data.code === 200){
      tableData.value = response.data.data;  
      total.value = response.data.total;
    } else {
      alert('Error al cargar los datos de la tabla');
    }
  }).catch((error) => {
    console.error('请求失败:', error);
  })
}

function add(){
  centerDialogVisible.value = true
}

function resetParam(){
  name.value = '' 
  sex.value = ''
  loadPage()
}


onBeforeMount(() => {
  loadPage()
})
</script>

<style scoped>

.dialogo {
  display: flex;
  flex-direction: column;
  align-items: center; 
}

.form-box {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center; 
}

.dialog-buttons {
  margin-top: 20px;
  text-align: center;
}

</style>