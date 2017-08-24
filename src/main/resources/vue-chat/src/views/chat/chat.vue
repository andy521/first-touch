<template>
    <div id="chat" class="row">
        <div class="col-md-3">
            <left></left>
        </div>
        <div class="col-md-3">
            <mid></mid>
        </div>
        <div class="col-md-6">
            <right></right>
        </div>
    </div>
</template>

<script>
    import left from './left.vue';
    import mid from './mid.vue';
    import right from './right.vue';
    export default {
        name: 'chat',
        data() {
            return {
            }
        },
        components: {
            left,
            mid,
            right
        },
        beforeCreate: function () { //获取单例全局信息，TODO 异步加载不太好
            console.log("app beforeCreate");
            //初始化全局用户信息 最好使用同步操作
            this.$http.get('/userInfo').then(response => {
                let data = response.body || null;
                this.$store.commit('init',data);
            }, response => {
                // error callback
            });
        }
    }

</script>

<style>
    #chat{
        margin-top:70px;
        height: 100px;
        width:80%;
    }
</style>