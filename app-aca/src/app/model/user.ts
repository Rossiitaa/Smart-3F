import { UserState } from "./user-state"

export class User {
    user_id!: number
    firstname!: string
    lastname!: string
    email!: string
    phoneNumber!: string
    qualification!: string
    residency!: string
    academy_start_date: any
    academy_end_date: any
    user_states!: UserState[]
}
