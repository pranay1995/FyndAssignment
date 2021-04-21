package resources;

public enum APIResources {
	
	AddOrDeleteOrUpdateOrGetUser("/users"),
	AddOrDeleteOrUpdateOrGetPosts("/posts"),
	AddOrDeleteOrUpdateOrGetComments("/comments"),
	AddOrDeleteOrUpdateOrGetAlbum("/albums");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	public String getResource()
	{
		return resource;
	}
}
