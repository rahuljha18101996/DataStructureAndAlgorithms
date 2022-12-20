package oops.others;

sealed class SealedEx permits SealedExt {

}

non-sealed class SealedExt extends  SealedEx {

}

final class NonSealedEx extends SealedExt {

}


//class Xyz extends NonSealedEx {
// No one can extends final classes
//}

public class SealedDemo {
}
