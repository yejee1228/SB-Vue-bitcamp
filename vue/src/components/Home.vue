<template>
<div>
	<layout>
		<template #header="header">
			<h1>{{header.title}}</h1>
			<div class="headerdiv">
				<component :is="whichCompo ? 'LogInHeader' : 'LogOutHeader'"></component>
			</div>
		</template>
		<template #sidebar="sidebar">
			<component :is="sidebarCheck"></component>
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
import LogInHeader from "@/components/cmm/LogInHeader.vue"
import LogOutHeader from "@/components/cmm/LogOutHeader.vue"
import AdminSidebar from "@/components/cmm/AdminSidebar.vue"
import StudentSidebar from "@/components/cmm/StudentSidebar.vue"
import PreSidebar from "@/components/cmm/PreSidebar.vue"
export default {
	components : {Layout, LogInHeader, LogOutHeader, 
			StudentSidebar, AdminSidebar, PreSidebar},
	computed: {
		whichCompo () {
			return this.$store.state.common.loginstate
			//alert(`this.$store.state.common.loginstate${this.$store.state.common.loginstate}`)
		},
		sidebarCheck : function () {
			return this.$store.state.common.sidebar
			//alert(`this.$store.state.common.sidebar${this.$store.state.common.sidebar}`)
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