<template>
 <el-scrollbar>
    <el-menu 
        background-color="#545c64"
        style="height: 100vh;"
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @open="handleOpen"
        @close="handleClose">
        <el-menu-item index="/Home"> 
           <el-icon style="font-size: 20px;">
              <HomeFilled />
           </el-icon>
           <span>Home</span>
        </el-menu-item>
        <el-menu-item index="/One"> 
           <el-icon style="font-size: 20px;">
              <Document />
           </el-icon>
           <span>Navegacion 1</span>
        </el-menu-item>
        <el-menu-item index="/Two">  
           <el-icon style="font-size: 20px;">
              <Folder />
           </el-icon>
           <span>Navegacion 2</span>
        </el-menu-item>
    </el-menu>
  </el-scrollbar>
</template>

<script lang="ts" setup>
import { HomeFilled, Document, Folder } from '@element-plus/icons-vue'
defineProps<{
  isCollapse: boolean
}>()

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style>
.el-menu .el-menu-item {
  color: #fff !important;
}

.el-menu .el-menu-item.is-active {
  color: #ffd04b !important;
  background-color: #434a50 !important;
}

.el-menu .el-menu-item:hover {
  color: #ffd04b !important;
  background-color: #434a50 !important;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>