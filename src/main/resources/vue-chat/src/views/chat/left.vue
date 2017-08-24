<template>

    <div id="left">
        {{userName}}
    </div>

</template>

<script>

    export default {
        name: 'left',
        data() {
            return {
            }
        },
        computed: { //通过计算属性 获取单例全局信息
            userName: function () {
                return this.$store.state.userName;
            }
        }
    }
</script>

<style>
    #left {
        background-color: green;
        height: 500px;
    }

</style>
