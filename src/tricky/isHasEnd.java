package tricky;
//what will be after run?
//что случится после запуска?

public class isHasEnd {
  public void run(){
    try{
      run();
    }finally {
      run();
    }
  }
}

// it freeze your PC because in try be StackOverFlowExeption but finally be completed anyway
// программа замораживает ваш компьютер, потому что в try выдает Stackoverflowexception, но, finally, будет завершен в любом случае
