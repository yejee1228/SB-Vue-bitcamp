import * as types from '@/store/modules/mutation_types'

const state = {
	context : 'http://localhost:8080/',
	loginstate : false,
	sidebar : 'preSidebar',
	headerMessage : '공통화면',
	error_state : '',
}
const getters = {
	getError_state : state => state.error_state,
	getContext : state => state.context,
	getLoginstate : state => state.loginstate,
	getSidebar : state => state.sidebar,
	getHeaderMessage : state => state.headerMessage,
}
const actions = {}
const mutations = {
	[types.ERROR_STATE] (state, error_state){
		state.error_state= error_state
	},
	[types.CONTEXT] (state, context){
		state.context= context
	},

	[types.LOGINSTATE] (state, loginstate){
		state.loginstate= loginstate
	},
	[types.SIDEBAR] (state, sidebar){
		state.sidebar= sidebar
	},
	[types.HEADERMESSAGE] (state, headerMessage){
		state.headerMessage= headerMessage
	},
}

export default {
	name: 'common',
	namespaced : true, // 재활용할 수 있다.
	state,
	getters,
	actions,
	mutations
}