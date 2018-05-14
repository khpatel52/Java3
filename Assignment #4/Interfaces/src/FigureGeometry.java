public interface FigureGeometry {
    final float PI = 3.14f;

    float perimeter();
    // Returns perimeter of this figure.

    float area();
    // Returns area of this figure.

    void setScale(int scale);
    // Scale of this figure is set to "scale."

    float weight();
    // Precondition: Scale of this figure has been set.
    //
    // Returns wight of this figure. Weight = are x scale.

    String getName();
}
