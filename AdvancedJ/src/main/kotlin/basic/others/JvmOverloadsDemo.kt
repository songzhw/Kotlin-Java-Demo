package basic.others

/*
How the default constructor parameters work?
: using the bit manipulation.

 */
class Book(var name: String,
           val isPopular: Boolean = false,
           val isForChildren: Boolean = false,
           val isEnglish: Boolean = false
           )

fun main(args: Array<String>) {
    Book("harry", isEnglish = true, isPopular = true )
    Book("potter", true, true)
}

/*

The generated constructor:

  public Book(@NotNull String name, boolean isPopular, boolean isForChildren, boolean isEnglish) {
      ...
   }

   // $FF: synthetic method
   public Book(String var1, boolean var2, boolean var3, boolean var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var2 = false;
      }

      if ((var5 & 4) != 0) {
         var3 = false;
      }

      if ((var5 & 8) != 0) {
         var4 = false;
      }

      this(var1, var2, var3, var4);
   }


 */