<template>
    <div style="display: flex; align-items: center; line-height: normal; padding: 10px 0;">
       <div style="margin-right: 28px;cursor: pointer;" @click="toggleMenu">
           <el-icon style=" font-size: 20px;">
              <Fold />
           </el-icon>
       </div>
        <div style="font-size: 34px;text-align:center;flex: 1;">
          <span>Bienvenido a la gestión del almacén</span>
       </div>
        <div class="toolbar">
            <span>Tom</span> 
          <el-dropdown @command="handleCommand">
             <el-icon style="margin-left: 8px; margin-top: 1px">
              <ArrowDown />
            </el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="toUser">Perfil Personal</el-dropdown-item>
                <el-dropdown-item command="logout">Salir de la sesaion</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </div>
</template>

<script setup>
import { ArrowDown } from '@element-plus/icons-vue'
import { Fold } from '@element-plus/icons-vue'

const emit = defineEmits(['toggle-collapse'])

const toggleMenu = () => {
  emit('toggle-collapse')
}

function handleCommand(command) {
  if (command === 'toUser') {
    console.log('toUser')
  } else if (command === 'logout') {
   console.log('logout')
  }
}

</script>

<style scoped>

</style>