package ng.ourChemo.data.models;

public class User {
        private String name;
        private String username;
        private String password;
        private String id;



        public String getName(){
            return name;
        }

          public void setName(String name) {
        this.name = name;
         }

         public String getUsername(){
            return username;
         }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassord(String passord) {
        this.password = password;
    }

    public String getId(){
            return id;
    }

    public void setId(String id){
            this.id = id;
    }
}
