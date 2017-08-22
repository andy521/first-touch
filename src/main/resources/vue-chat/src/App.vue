<template>
    <div id="app">
        <top></top>
        <router-view></router-view>
        <bottom></bottom>
    </div>
</template>

<script>
    import top from './views/top.vue'
    import bottom from './views/bottom.vue'
    export default {
        name: 'app',
        data() {
            return {
            }
        },
        components: {
            top,
            bottom
        },
        beforeCreate: function () { //获取单例全局信息，TODO 异步加载不太好

        }
    }
</script>

<style>
    /*全局样式放在这里*/

    .cut {
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
    }

    a {
        cursor: hand;
    }

    ul {
        list-style-type: none;
        margin: 0px;
    }

    .fs14 {
        font-size: 14px;
    }

    .fs16 {
        font-size: 16px;
    }

    .fs18 {
        font-size: 18px;
    }

    .fs20 {
        font-size: 20px;
    }

    .fs22 {
        font-size: 22px;
    }

    .fs24 {
        font-size: 24px;
    }

    .fw400 {
        font-weight: 400;
    }

    .fw700 {
        font-weight: 700;
    }

    .fw900 {
        font-weight: 900;
    }

    .lh1-5 {
        line-height: 1.5;
    }

    .lh2 {
        line-height: 2;
    }

    input::-webkit-input-placeholder { /* WebKit browsers */
        font-size: 16px;
    }

    input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
        font-size: 16px;
    }

    input::-moz-placeholder { /* Mozilla Firefox 19+ */
        font-size: 16px;
    }

    input :-ms-input-placeholder { /* Internet Explorer 10+ */
        font-size: 16px;
    }
</style>