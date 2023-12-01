package lz4;

import java.util.Objects;

public class GuitarBody {
    //поля класу
    private String bodyType;
    private String bodyMaterial;
    //конструктори
    public GuitarBody(){}
//геттери та сеттери
    public GuitarBody(String bodyType, String bodyMaterial) {
        this.bodyType = bodyType;
        this.bodyMaterial = bodyMaterial;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }
    //метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuitarBody that = (GuitarBody) o;
        return Objects.equals(bodyType, that.bodyType) && Objects.equals(bodyMaterial, that.bodyMaterial);
    }
//метод hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (bodyType == null ? 0 : bodyType.hashCode());
        hash = 31 * hash + (bodyMaterial == null ? 0 : bodyMaterial.hashCode());
        return hash;
    }
//метод toString
    @Override
    public String toString() {
        return "GuitarBody{" +
                "bodyType='" + bodyType + '\'' +
                ", bodyMaterial='" + bodyMaterial + '\'' +
                '}';
    }
}
