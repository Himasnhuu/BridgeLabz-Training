package week3.CustomBrowser;

public class Page {
	String url;
	Page prev;
	Page next;

	public Page(String url) {
		this.url = url;
	}
}