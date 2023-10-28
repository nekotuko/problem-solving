package solution;

public class VersionControl {
    private final int mBadVersion;

    VersionControl(int version) {
        mBadVersion = version;
    }

    boolean isBadVersion(int version) {
        return version >= mBadVersion;
    }
}
