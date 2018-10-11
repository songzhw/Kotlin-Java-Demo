package rxjava2.fortest

interface IProfileView {
    fun refresh(profile: Profile)
}

class ProfileView : IProfileView{
    override fun refresh(profile: Profile) {
        println("szw refresh : $profile")
    }

}