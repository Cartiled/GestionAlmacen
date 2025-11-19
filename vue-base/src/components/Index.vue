<template>
  <el-container class="layout-container-demo" style="height: 100%">
    <el-aside :width="aside_width" >
     <Aside :is-collapse="isCollapse"> </Aside>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px;border-bottom: darkgray 1px solid;">
         <Header @toggle-collapse="toggleCollapse"></Header>
      </el-header>
        <Main></Main>
      <el-main>
       
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import Aside from '@/components/Aside.vue'
import Header from '@/components/Header.vue'
import Main from '@/components/Main.vue'

const isCollapse = ref(false)
const aside_width = ref('200px')

const toggleCollapse = () => {
  isCollapse.value = !isCollapse.value

  if (!isCollapse.value) {
    aside_width.value = '200px'
  } else {
    aside_width.value = '64px'
  }
}

</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  margin: 0;
   background-color :#B3C0D1;
   color: #333;
   line-height: 60px;
}
.layout-container-demo .el-aside {
 display: flex;
  flex-direction: column;
  height: 100%;
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
  overflow: hidden;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
.layout-container-demo .el-container {
  height: 100%;
}
</style>