package pair;
public class Pair<L,R> {
	private L l;
	private R r;
	public Pair(L l, R r){
		this.r = r;
		this.l = l;
	}
	public L getL(){
		return this.l;
	}
	public R getR(){
		return this.r;
	}
}
