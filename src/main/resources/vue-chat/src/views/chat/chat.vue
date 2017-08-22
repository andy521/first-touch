<template>
    <div id="chat" class="row">
        <div class="col-md-3">
            <left></left>
        </div>
        <div class="col-md-3">
            <right></right>
        </div>
        <div class="col-md-6">
            <right></right>
        </div>
    </div>
</template>

<script>
    import left from './left.vue';
    import right from './right.vue';
    export default {
        name: 'chat',
        data() {
            return {
            }
        },
        components: {
            left,
            right
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