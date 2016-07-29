package multildatasource;

public class DataSourceHolder {
	
	private static final  ThreadLocal<String> dataSourceHolder = new ThreadLocal<String>();
	
	public static String get(){
		return dataSourceHolder.get();
	}
	
	public static void set(String key){
		dataSourceHolder.set(key);
	}
	
	public static void setMainDataSource(){
		DataSourceHolder.set("");
	}
}
