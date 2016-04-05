import java.util.List;

public class NestedInt implements NestedInteger {
	private Object nestedInt;

	public NestedInt(Object o) {
		this.nestedInt = o;
	}

	@Override
	public boolean isInteger() {
		return (nestedInt instanceof Integer) ? true : false;
	}

	@Override
	public Integer getInteger() {
		if (isInteger())
			return (int) nestedInt;
		else
			return null;
	}

	@Override
	public List<NestedInteger> getList() {
		if (!isInteger())
			return (List<NestedInteger>) nestedInt;
		else
			return null;
	}

	@Override
	public List<NestedInteger> convert(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
