import BuildProductDimension.ENVIRONMENT
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

object BuildProductDimension {
  const val ENVIRONMENT = "environment"
}

interface BuildProductFlavor {
  val name: String
  fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor
}

object ProductFlavorDevelop : BuildProductFlavor {
  override val name = "dev"

  override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
    return namedDomainObjectContainer.create(name) {
      applicationIdSuffix = ".dev"
      versionNameSuffix = "-dev"
      dimension = ENVIRONMENT
    }
  }
}

object ProductFlavorQA : BuildProductFlavor {
  override val name = "qa"

  override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
    return namedDomainObjectContainer.create(name) {
      applicationIdSuffix = ".qa"
      versionNameSuffix = "-qa"
      dimension = ENVIRONMENT
    }
  }
}

object ProductFlavorProduction : BuildProductFlavor {
  override val name = "prod"

  override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
    return namedDomainObjectContainer.create(name) {
      dimension = ENVIRONMENT
    }
  }
}
