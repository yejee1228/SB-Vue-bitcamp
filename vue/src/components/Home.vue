<template>
<div>
	<layout>
		<template #header="header">
			<h1>{{header.title}}</h1>
			<div class="headerdiv">
				<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			</div>
		</template>
		<template #sidebar="sidebar">
			<ul class="menu">
				<li v-for="i of sidebars" :key="i.menu">
					<router-link :to="i.link">{{i.menu}}</router-link>
				</li>
			</ul>
		</template>
		<template #content="content">
			<router-view/>
		</template>
		<template #footer="footer">
			{{footer.footerText}}
		</template>
	</layout>
</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import PostAuth from "@/components/cmm/PostAuth.vue"
import PreAuth from "@/components/cmm/PreAuth.vue"
import {store} from "../store"
export default {
	name : 'home',
	components : {
		Layout, PostAuth, PreAuth
	},
	data(){
		return{
			sidebars:[
				{menu:"호오옴", link: "/"},
				{menu:"글쓰기", link: "/write"},
				{menu:"글목록", link: "/list"},
				{menu:"글수정", link: "/update"},
				{menu:"글삭제", link: "/remove"},
				{menu:"거엄색", link: "/search"}
			],
			login: "/login",
			join: "/join",
		}
	},
	computed:{
		loginCheck: function(){
			return store.state.authCheck
		}
		
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
}
ul.menu a {
    text-decoration:none;
}
.headerdiv{
	float: right;
}
h1 {
	margin: auto;
    text-align: center;
}
</style>