import { States } from "./states"
import { UserState } from "./user-state"

export class State {
    state_id!: number
    state!: States
    user_states!: UserState
}
