import * as types from '@/store/mutation_types'
export default {
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
	[types.LIST] (state, list){
		state.list= list
	},
}
