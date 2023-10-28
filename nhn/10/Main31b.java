//1024(화) -> basic -> 객체비교
import java.util.Objects;

public class Main31b {

  private final String userId;
  private final String userName;

  public Main31b(String userId, String userName){
    this.userId = userId;
    this.userName = userName;
  }

  public String getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  //todo user 객체의 비교가 될 수 있도록 구현합니다.
  @Override
  public boolean equals(Object o){

    if(o instanceof Main31b){
        if(((Main31b)o).getUserId().equals(this.userId) 
                && ((Main31b)o).getUserName().equals(this.userName)){
            return true;
        }
    }
    return false;
  }


  public static void main(String[] args) {
        Main31b user1 = new Main31b("user1", "hi");
        Main31b user2 = new Main31b("user2", "hello");

        // 객체 동등성 비교
        boolean equal1 = user1.equals(user2);
        System.out.println("equal : " + equal1);

        // 다른 객체 생성
        Main31b user3 = new Main31b("user1", "hi");

        // 객체 동등성 비교
        boolean equal2 = user1.equals(user3);
        System.out.println("equal2 : " + equal2);
  }
}

