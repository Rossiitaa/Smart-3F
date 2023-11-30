import { UserState } from "./user-state"

export class User {
    user_id!: number
    firstname!: string
    lastname!: string
    
    user_states!: UserState[]
}
