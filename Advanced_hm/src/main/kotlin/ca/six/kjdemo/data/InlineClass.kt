package ca.six.kjdemo.data

inline class DogId(@JvmField val id: Long)
data class Dog(val id: DogId)

/*
inline类, 类似inline函数, 其编译后是这样的:
public final class Dog {
   private final long id;

   public final long getId() {
      return this.id;
   }

   private Dog(long id) {
      this.id = id;
   }

看到了吧, 是直接把id给传进去了. 所以不用担心内存中类过多)
 */